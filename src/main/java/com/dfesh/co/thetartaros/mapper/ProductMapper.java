package com.dfesh.co.thetartaros.mapper;

import com.dfesh.co.thetartaros.dto.ProductDTO;
import com.dfesh.co.thetartaros.model.Product;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductDTO ProductToProductDTO(Product product);

    Product ProductDTOToProduct(ProductDTO productDTO);

    List<ProductDTO> ProductToProductDTO(List<Product> products);

}
