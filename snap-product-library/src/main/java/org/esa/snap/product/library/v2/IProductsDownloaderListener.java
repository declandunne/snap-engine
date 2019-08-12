package org.esa.snap.product.library.v2;

import ro.cs.tao.eodata.EOProduct;

import java.util.List;

/**
 * Created by jcoravu on 9/8/2019.
 */
public interface IProductsDownloaderListener {

    void notifyProductCount(long productCount);

    void notifyPageProducts(int pageNumber, List<EOProduct> pageResults);
}
