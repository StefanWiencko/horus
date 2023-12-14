import java.util.Arrays;
import java.util.List;

//W odpowiedzi na zainteresowanie naszą ofertą pracy chcielibyśmy zaprosić Panią do pierwszego etapu rekrutacji na stanowisko Junior Java Developer w firmie Horus.
//Poniżej przekazujemy zadanie z prośbą o analizę poniższego kodu i zaimplementowanie metod findBlockByColor, findBlocksByMaterial, count w klasie Wall - najchętniej unikając powielania kodu i umieszczając całą logikę w klasie Wall. Z uwzględnieniem w analizie i implementacji interfejsu blocks.CompositeBlock!

public class Main {
    public static void main(String[] args) {

        List<Block> inputList = Arrays.asList(
                new SimpleBlockImpl("Red", "Wood"),
                new SimpleBlockImpl("Blue", "Stone"),
                new CompositeBlockImpl(
                        new SimpleBlockImpl("Green", "Metal"),
                        new SimpleBlockImpl("Yellow", "Concrete"),
                        new CompositeBlockImpl(
                                new SimpleBlockImpl("Green", "Metal"),
                                new SimpleBlockImpl("Yellow", "Concrete")
                        )),
                new SimpleBlockImpl("Black", "Brick"),
                new CompositeBlockImpl(
                        new SimpleBlockImpl("Green", "Concrete"),
                        new SimpleBlockImpl("Yellow", "Metal")
                )
        );
        CompositeBlockImpl compositeBlock = new CompositeBlockImpl(
                new SimpleBlockImpl("Green", "Concrete"),
                new SimpleBlockImpl("Yellow", "Metal"),
                new CompositeBlockImpl(
                        new SimpleBlockImpl("Green", "Concrete"),
                        new SimpleBlockImpl("Blue", "Metal")
                )
        );

        System.out.println(compositeBlock.color());
        Wall wall = new Wall(inputList);

        System.out.println(wall.count());
        System.out.println(wall.findBlockByColor("Yellow"));
        System.out.println(wall.findBlocksByMaterial("Metal"));

    }
}

