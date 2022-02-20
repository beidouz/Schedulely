package com.schedulely.app.utilities;

import org.hashids.*;

//https://github.com/yomorun/hashids-java
public class UrlFactory extends Hashids {

    private static UrlFactory urlFactory = new UrlFactory();

    private UrlFactory() {
        super("salt for schedulely", 6); // create an instance of Hashids
    }

    public static UrlFactory getInstance() {
        return urlFactory;
    }
}
