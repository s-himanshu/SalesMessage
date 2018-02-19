package com.org.utils;

/**
 * Created by  Himanshu Singh on 18/02/2018.
 *
 * Class Name: MessageParser
 *
 *      Parses a sales message and obtains product details. Ignores parsing of any invalid string and returns
 *      false.
 */

public class MessageParser {

    // Parsed product type
    private String productType;

    // Parsed product price
    private double productPrice;

    // Parsed product quantity
    private int productQuantity;

    // Parsed product operatorType e.g Add, Subtract
    private String operatorType;

    // Constructor on initialisation parses the
    // product details.
    public MessageParser(String message) {
        this.productType = "";
        this.productPrice = 0.0;
        this.productQuantity = 0;
        this.operatorType = "";
        parseMessage(message);
    }

    // Validates the message and identifies the message type to get it
    // parsed properly to obtain product details.
    // @return[Boolean] false on wrong message else returns true
    private boolean parseMessage(String message) {
        if (message == null || message.isEmpty()) {
            return false;
        }
        String[] messageArray = message.trim().split("\\s+");
        String firstWord = messageArray[0];
        if (firstWord.matches("Add|Subtract|Multiply")) {
            return parseMessageType3(messageArray);
        } else if (firstWord.matches("^\\d+")) {
            return parseMessageType2(messageArray);
        } else if (messageArray.length == 3 && messageArray[1].contains("at")) {
            return parseMessageType1(messageArray);
        } else {
            System.out.println("Wrong sales notice");
        }
        return true;
    }

    // Parse message type 1
    private boolean parseMessageType1(String[] messageArray) {
        if(messageArray.length > 3 || messageArray.length < 3) return false;
        productType = parseType(messageArray[0]);
        productPrice = parsePrice(messageArray[2]);
        productQuantity = 1; //Will always be 1
        return true;
    }

    // Parse message type 2
    private boolean parseMessageType2(String[] messageArray) {
        if(messageArray.length > 7 || messageArray.length < 7) return false;
        productType = parseType(messageArray[3]);
        productPrice = parsePrice(messageArray[5]);
        productQuantity = Integer.parseInt(messageArray[0]);
        return true;
    }

    // Parse message type 3
    private boolean parseMessageType3(String[] messageArray) {
        if(messageArray.length > 3 || messageArray.length < 3) return false;
        operatorType = messageArray[0];
        productType = parseType(messageArray[2]);
        productQuantity = 0;
        productPrice = parsePrice(messageArray[1]);
        return true;
    }

    // Just to handle the plural cases of the fruit products
    // Made under the assumption that no other sale items will be given. e.g Tumbler, Plates. etc.
    // @return[String] parsed string e.g 'mango' will become 'mangoes'
    public String parseType(String rawType) {
        String parsedType = "";
        String typeWithoutLastChar = rawType.substring(0, rawType.length() - 1);
        //enum DEPREC
        if (rawType.endsWith("o")) {
            parsedType = String.format("%soes", typeWithoutLastChar);
        } else if (rawType.endsWith("y")) {
            parsedType = String.format("%sies", typeWithoutLastChar);
        } else if (rawType.endsWith("h")) {
            parsedType = String.format("%shes", typeWithoutLastChar);
        } else if (!rawType.endsWith("s")) {
            parsedType = String.format("%ss", rawType);
        } else {
            parsedType = String.format("%s", rawType);
        }
        return parsedType.toLowerCase();
    }

    // Parse the price and get only the value
    // @return[double] e.g "20p" will become 0.20
    public double parsePrice(String rawPrice) {
        double price = Double.parseDouble(rawPrice.replaceAll("£|p", ""));
        if (!rawPrice.contains(".")) {
            price = Double.valueOf(Double.valueOf(price) / Double.valueOf("100"));
        }
        return price;
    }

    // Get the product type
    public String getProductType() {
        return productType;
    }

    // Get the product price
    public double getProductPrice() {
        return productPrice;
    }

    // Get the operator type
    public String getOperatorType() {
        return operatorType;
    }

    // Get the product quantity
    public int getProductQuantity() {
        return productQuantity;
    }


}