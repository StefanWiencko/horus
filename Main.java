import java.util.Arrays;
import java.util.List;

//W odpowiedzi na zainteresowanie naszą ofertą pracy chcielibyśmy zaprosić Panią do pierwszego etapu rekrutacji na stanowisko Junior Java Developer w firmie Horus.
//Poniżej przekazujemy zadanie z prośbą o analizę poniższego kodu i zaimplementowanie metod findBlockByColor, findBlocksByMaterial, count w klasie Wall - najchętniej unikając powielania kodu i umieszczając całą logikę w klasie Wall. Z uwzględnieniem w analizie i implementacji interfejsu blocks.CompositeBlock!

public class Main {
    public static void main(String[] args) {

        List<Block> inputList = Arrays.asList(
                new BlockImpl("Red", "Wood"),
                new BlockImpl("Blue", "Stone"),
                new CompositeBlockImpl(Arrays.asList(
                        new BlockImpl("Green", "Metal"),
                        new BlockImpl("Yellow", "Concrete"),
                        new CompositeBlockImpl(Arrays.asList(
                                new BlockImpl("Green", "Metal"),
                                new BlockImpl("Yellow", "Concrete")
                        ))
                )),
                new BlockImpl("Black", "Brick"),
                new CompositeBlockImpl(Arrays.asList(
                        new BlockImpl("Green", "Concrete"),
                        new BlockImpl("Yellow", "Metal")
                ))
        );

        Wall wall = new Wall(inputList);

        System.out.println(wall.count());
        System.out.println(wall.findBlockByColor("Yellow"));
        System.out.println(wall.findBlocksByMaterial("Metal"));

    }
}

