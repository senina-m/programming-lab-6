package ru.senina.itmo.lab6.commands;

import ru.senina.itmo.lab6.CollectionElement;
import ru.senina.itmo.lab6.ICollectionKeeper;
import ru.senina.itmo.lab6.InvalidArgumentsException;

/**
 * Command removes element from collection by it's ID
 */
@CommandAnnotation(name = "remove_by_id", collectionKeeper = true, id = true)
public class RemoveByIDCommand<T extends CollectionElement> extends Command<T> {
    private ICollectionKeeper<T> collectionKeeper;
    private long id;

    public RemoveByIDCommand() {
        super("remove_by_id id", "remove an item from the collection by its id");
    }

    public void setArgs(ICollectionKeeper<T> collectionKeeper){
        this.collectionKeeper = collectionKeeper;
    }

    @Override
    protected String doRun(){
        return collectionKeeper.removeById(id);
    }

    @Override
    public void validateArguments() {
        String[] args = this.getArgs();
        if(args.length == 2){
            this.id = Long.parseLong(args[1]);
        }else {
            throw new InvalidArgumentsException("Remove_by_id command has the only argument - id.");
        }
    }
}
