package com.company;

import java.awt.*;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;

public class CatalogUtil {
    //create the file with save method
    public static void save(Catalog catalog) throws IOException {
        try (var oos = new ObjectOutputStream(
                new FileOutputStream(catalog.getPath()))) {
            oos.writeObject(catalog);
        }
    }

    public static Catalog load(String path) throws InvalidCatalogException, IOException, ClassNotFoundException {
        InputStream fileIs = new FileInputStream(path);
        ObjectInputStream objInptstr = new ObjectInputStream(fileIs);
        Catalog loadedCatalog = (Catalog) objInptstr.readObject();
        return loadedCatalog;
    }


    public static void view(Document doc) throws URISyntaxException, IOException {
        Desktop desktop = Desktop.getDesktop();

        URI uri = new URI(doc.getLocation());

        if (Desktop.isDesktopSupported()) {
            desktop = Desktop.getDesktop();
        }
        if (desktop != null) {
            //opens the link in the browser
            desktop.browse(uri);
        }
    }


}