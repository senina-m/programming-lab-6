package ru.senina.itmo.lab6;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.senina.itmo.lab6.labwork.LabWork;
import ru.senina.itmo.lab6.parser.JsonParser;
import ru.senina.itmo.lab6.parser.ParsingException;

import java.util.LinkedList;

public class CollectionKeeperParser extends JsonParser<CollectionKeeper> {

    public CollectionKeeperParser(ObjectMapper objectMapper, Class<CollectionKeeper> classT) {
        super(objectMapper, classT);
    }

    public String fromCollectionToStringElements(CollectionKeeper object) throws ParsingException {
        StringBuilder resultString = new StringBuilder();
        LinkedList<LabWork> list = object.getList();
        for (int i = 0; i < list.size(); i++) {
            resultString.append("\nElement ").append(i + 1).append(":\n").append(fromElementToString(list.get(i)));
        }
        return resultString.toString();
    }

    public String fromElementToString(LabWork element) throws ParsingException {
        try {
            return CollectionKeeperParser.getObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(element);
        } catch (JsonProcessingException e) {
            throw new ParsingException("Something wrong with element id: " + element.getId());
        }
    }

    public LabWork fromStringToElement(String json) throws ParsingException {
        try {
            return CollectionKeeperParser.getObjectMapper().readValue(json, LabWork.class);
        } catch (JsonProcessingException e) {
            throw new ParsingException("Something wrong with element string -> object parsing.");
        }
    }

    @Override
    public String fromObjectToString(CollectionKeeper collectionKeeper) throws ParsingException {
        try {
            return CollectionKeeperParser.getObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(collectionKeeper.getList());
        } catch (JsonProcessingException e) {
            throw new ParsingException("Something wrong with parsing collection to string.");
        }
    }
}
