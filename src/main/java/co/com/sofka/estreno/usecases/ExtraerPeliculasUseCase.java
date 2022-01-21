package co.com.sofka.estreno.usecases;

import co.com.sofka.estreno.domain.estreno.Estreno;
import co.com.sofka.estreno.domain.estreno.command.ExtraerPeliculaCommand;
import co.com.sofka.estreno.domain.generic.DomainEvent;
import co.com.sofka.estreno.domain.generic.EventStoreRepository;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.enterprise.context.Dependent;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.function.Function;

@Dependent
public class ExtraerPeliculasUseCase implements Function<ExtraerPeliculaCommand, List<DomainEvent>> {

    private final EventStoreRepository repository;

    private static final String URL_BASE = "https://pelisplus.so/estrenos";


    public ExtraerPeliculasUseCase(EventStoreRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<DomainEvent> apply(ExtraerPeliculaCommand command) {

        var estreno = Estreno.from(command.getEstrenoId(),
                repository.getEventsBy("estreno", command.getEstrenoId()));

        // Compruebo si me da un 200 al hacer la petición
        if (getStatusConnectionCode(URL_BASE) == 200) {

            // Obtengo el HTML de la web en un objeto Document
            Document document = getHtmlDocument(URL_BASE);

            // Busco todas las entradas que estan dentro de:
            Elements entradas = document.select("div.item-pelicula");

            // Paseo cada una de las entradas
            for (Element elem : entradas) {
                String urlPelicula = elem.getElementsByTag("a").attr("href");

                Document documentPelicula = getHtmlDocument("https://pelisplus.so" + urlPelicula);

                String urlVideos = documentPelicula.getElementsByClass("tab-video").attr("data-video");
                String titulo = documentPelicula.getElementsByTag("h1").text();
                String imagenURL = documentPelicula.getElementById("cover").attr("src");
                String anio = documentPelicula.getElementsByClass("info-half").text();
                String[] datosPelicula = anio.split(" ");
                String sipnosis = documentPelicula.getElementsByClass("sinopsis").text();
                String generos = documentPelicula.getElementsByClass("content-type-a").text();

                System.out.println("URL IMAGEN: " + imagenURL);
                estreno.agregarPelicula(UUID.randomUUID().toString().substring(0,10), titulo, imagenURL, datosPelicula[1], datosPelicula[3]+" "+datosPelicula[4], generos, sipnosis, urlVideos);

            }

        }else
            System.out.println("El Status Code no es OK es: "+getStatusConnectionCode(URL_BASE));

        return estreno.getUncommittedChanges();
    }


    public static int getStatusConnectionCode(String url) {

        Connection.Response response = null;

        try {
            response = Jsoup.connect(url).userAgent("Mozilla/5.0").timeout(100000).ignoreHttpErrors(true).execute();
        } catch (IOException ex) {
            System.out.println("Excepción al obtener el Status Code: " + ex.getMessage());
        }
        return response.statusCode();
    }

    public static Document getHtmlDocument(String url) {

        Document doc = null;
        try {
            doc = Jsoup.connect(url).userAgent("Mozilla/5.0").timeout(100000).get();
        } catch (IOException ex) {
            System.out.println("Excepción al obtener el HTML de la página" + ex.getMessage());
        }
        return doc;
    }
}
