package com.dfesh.co.thetartaros.service;

import com.dfesh.co.thetartaros.dto.ProductDTO;
import com.dfesh.co.thetartaros.exceptions.ProductAlreadyExistsException;
import com.dfesh.co.thetartaros.mapper.ProductMapper;
import com.dfesh.co.thetartaros.model.Product;
import com.dfesh.co.thetartaros.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private static final Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;


    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public ProductDTO saveProduct(ProductDTO productDTO) {
        Optional<Product> existingProduct = productRepository.findById(productDTO.getId());
        if (existingProduct.isPresent()) {
            throw new ProductAlreadyExistsException("A product with the name '" + productDTO.getName() + "' already exists.");
        }
        Product product = productMapper.ProductDTOToProduct(productDTO);
        return productMapper.ProductToProductDTO(productRepository.save(product));
    }

    @Override
    public ProductDTO findById(Long id) {
        // log.debug("Attempting to find product by ID: {}", id);

        Product product = productRepository.findById(id)
                .orElseThrow(() -> {
                    log.warn("Product with ID '{}' not found.", id);
                    return new ProductNotFoundException("Product with ID '" + id + "' not found.");
                });
                return productMapper.ProductToProductDTO(product);
    }

    @Override
    public ProductDTO getProduct(Long id) {
        return null;
    }


    @Override
    public List<ProductDTO> getProducts() {
        List<Product> products = productRepository.findAll();

        List<ProductDTO> productDTOS = products.stream()
                .map(productMapper::ProductToProductDTO)
                .collect(Collectors.toList());
        return productDTOS;
    }

    @Override
    public List<ProductDTO> getProductsByCategory(String category) {
        return List.of();
    }

    @Override
    public ProductDTO updateProduct(Long id, ProductDTO productDTO) {
        return null;
    }

    @Override
    public ProductDTO deleteProduct(Long id) {
        return null;
    }
}
