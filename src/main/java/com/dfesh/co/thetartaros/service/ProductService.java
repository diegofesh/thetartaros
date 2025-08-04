package com.dfesh.co.thetartaros.service;

import com.dfesh.co.thetartaros.dto.ProductDTO;

import java.util.List;

public interface ProductService {

    public ProductDTO saveProduct(ProductDTO productDTO);

    public ProductDTO getProduct(Long id);

    public ProductDTO findById(Long id);

    public List<ProductDTO> getProducts();

    public List<ProductDTO> getProductsByCategory(String category);

    public ProductDTO updateProduct(Long id, ProductDTO productDTO);

    public ProductDTO deleteProduct(Long id);
}
