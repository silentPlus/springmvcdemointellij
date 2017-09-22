/**
 * Created by suvan on 2017/5/15.
 */
public class Test {
    public static void main(String[] args) {

        /*Map<String, String> map = new HashMap<>();
        System.out.println(Math.abs(Double.parseDouble(map.get("a"))));*/
    }

}

class A{

}

enum Fruit{
    aaa("1", "2"),
    bbb("3", "4");

    private String color;
    private String weight;

    Fruit(String color, String weight) {
        this.color = color;
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public String getWeight() {
        return weight;
    }

}