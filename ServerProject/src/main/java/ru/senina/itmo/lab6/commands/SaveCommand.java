package ru.senina.itmo.lab6.commands;

import ru.senina.itmo.lab6.CollectionKeeper;
import ru.senina.itmo.lab6.CollectionKeeperParser;
import ru.senina.itmo.lab6.parser.Parser;

/**
 * Command saves collection to file
 */
@CommandAnnotation(name = "save", collectionKeeper = true, parser = true, filename = true)
public class SaveCommand extends CommandWithoutArgs {
    private CollectionKeeper collectionKeeper;
    private CollectionKeeperParser parser;
    private final String filename;

    public SaveCommand(String filename) {
        super("save", "save collection to file");
        this.filename = filename;
    }

    public void setCollectionKeeper(CollectionKeeper collectionKeeper) {
        this.collectionKeeper = collectionKeeper;
    }

    public void setParser(CollectionKeeperParser parser) {
        this.parser = parser;
    }

    @Override
    protected String doRun() {
        Parser.writeStringToFile(filename, parser.fromObjectToString(collectionKeeper));
        return "Collection was successfully saved to " + filename + " file.";
    }
}
