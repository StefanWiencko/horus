import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Wall implements Structure {
    private final List<Block> blocks;

    public Wall(List<Block> list) {
        this.blocks = flattenCompositeBlocks(list);
    }

    @Override
    public Optional<Block> findBlockByColor(String color) {
        return blocks.stream()
                .filter(block -> block.color().equals(color))
                .findFirst();
    }

    @Override
    public List<Block> findBlocksByMaterial(String material) {
        return blocks.stream()
                .filter(block -> block.material().equals(material))
                .collect(Collectors.toList());
    }

    @Override
    public int count() {
        return blocks.size();
    }

    private List<Block> flattenCompositeBlocks(List<Block> inputList) {
        return inputList.stream()
                .flatMap(block ->
                        block instanceof CompositeBlockImpl ?
                                flattenCompositeBlocks(((CompositeBlockImpl) block).getBlocks()).stream() :
                                Stream.of(block))
                .collect(Collectors.toList());
    }

}

record SimpleBlockImpl(String color, String material) implements Block {
}

class CompositeBlockImpl implements CompositeBlock {
    private final List<Block> blocksList = new ArrayList<>();

    public CompositeBlockImpl(Block... list) {
        blocksList.addAll(Arrays.asList(list));
    }

    @Override
    public String color() {
        return aggregateBlocksInfo(Block::color);
    }

    @Override
    public String material() {
        return aggregateBlocksInfo(Block::material);
    }

    @Override
    public List<Block> getBlocks() {
        return this.blocksList;
    }

    private String aggregateBlocksInfo(Function<Block, String> propertyExtractor) {
        return blocksList.stream()
                .map(propertyExtractor)
                .reduce((prop1, prop2) -> prop1 + ", " + prop2)
                .orElse("Unknown");
    }

}
