package service;

import java.util.List;

import model.Product;
import net.sf.json.JSONObject;
import VO.ProductVo;

public interface ProductService {

    /**
     * Save a Product entity
     * @param productVo
     */
    void saveProduct(ProductVo productVo);

    /**
     * Update a Product entity
     * @param productVo
     */
    void updateProduct(ProductVo productVo);

    /**
     * Get a Product entity
     * @param productVo
     * @return
     */
    JSONObject getProduct(ProductVo productVo);

    /**
     * Find all kinds of products
     * @return
     */
    List<Product> findAllKindsProducts();

    /**
     * Find products by type
     * @param productVo
     * @return
     */
    List<Product> findProductsByType(ProductVo productVo);

    /**
     * Delete a product entity
     * @param productVo
     */
    void deleteProduct(ProductVo productVo);

}
