package com.company;

import java.io.IOException;
import java.net.URISyntaxException;

public class Main {

    public static void main(String[] args) throws IOException, InvalidCatalogException, URISyntaxException, ClassNotFoundException {
        Main app = new Main();
        app.testCreateSave();
        app.testLoadView();

    }

    private void testCreateSave() throws IOException {
        //create new objects. Constructors are made in their classes
        Catalog catalog = new Catalog("Java Resources", "b:/zjava/catalog.ser");
        Document doc = new Document("java1", "Java Course 1",
                "https://profs.info.uaic.ro/~acf/java/slides/en/intro_slide_en.pdf");
        doc.addTag("type", "Slides");
        catalog.add(doc);
        //we got the paths, let's create the file :)
        CatalogUtil.save(catalog);
    }

    private void testLoadView() throws InvalidCatalogException, IOException, ClassNotFoundException, URISyntaxException {
        //create catalog and assign datas from path
        Catalog catalog = CatalogUtil.load("b:/zjava/catalog.ser");
        Document doc = catalog.findById("java1");

        //view the document
        CatalogUtil.view(doc);
    }


}
