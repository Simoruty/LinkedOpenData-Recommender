import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: lusio
 * Date: 12/03/13
 * Time: 0.47
 */
public class Edge implements Serializable {

    private Property property;
    private String title;
    private Film subject;
    private Risorsa object;
    private double weight;


    public Edge(Property property, Film subject, Risorsa object, double weight) {
        this.property = property;
        this.title = property.getUri().
                replace("http://dbpedia.org/resource/", "")
                .replace("http://dbpedia.org/ontology/", "")
                .replace("http://purl.org/dc/terms/", "")
                .replace("http://dbpedia.org/property/", "")
                .replace("http://dbpedia.org/resource/", "")
                .replace(".", "_").replace(":", "_").replace(",", "_").replace("-", "_");
        this.subject = subject;
        this.object = object;
        this.weight = weight;
    }

    public Edge(Property property, Film subject, Risorsa object) {
        this(property, subject, object, 1);
    }

    public Property getProperty() {
        return property;
    }

    public String getTitle() {
        return title;
    }

    public Film getSubject() {
        return subject;
    }

    public Risorsa getObject() {
        return object;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Edge edge = (Edge) o;

        if (Double.compare(edge.weight, weight) != 0) return false;
        if (object != null ? !object.equals(edge.object) : edge.object != null) return false;
        if (property != null ? !property.equals(edge.property) : edge.property != null) return false;
        if (subject != null ? !subject.equals(edge.subject) : edge.subject != null) return false;
        if (title != null ? !title.equals(edge.title) : edge.title != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = property.hashCode();
        result = 31 * result + title.hashCode();
        result = 31 * result + subject.hashCode();
        result = 31 * result + object.hashCode();
        temp = weight != +0.0d ? Double.doubleToLongBits(weight) : 0L;
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}