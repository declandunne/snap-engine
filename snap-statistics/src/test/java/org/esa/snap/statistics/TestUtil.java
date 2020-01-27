package org.esa.snap.statistics;

import org.esa.snap.core.dataio.ProductIO;
import org.esa.snap.core.datamodel.Product;
import org.esa.snap.core.util.Guardian;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class TestUtil {

    public static Product getTestProduct() throws IOException, URISyntaxException {
        URL resource = TestUtil.class.getResource("testProduct1.dim");
        final URI uri = new URI(resource.toString());
        return ProductIO.readProduct(uri.getPath());
    }

    public static void deleteTreeOnExit(File tree) {
        Guardian.assertNotNull("tree", tree);

        File[] files = tree.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    deleteTreeOnExit(file);
                } else {
                    file.deleteOnExit();
                }
            }
        }
        tree.deleteOnExit();
    }
}
