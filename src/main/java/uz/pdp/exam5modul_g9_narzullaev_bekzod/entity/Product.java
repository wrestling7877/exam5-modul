package uz.pdp.exam5modul_g9_narzullaev_bekzod.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

    private Integer id;

    private String name;

    private Category category;

    private Integer categoryId;

    private Double salary;

    private String imgUrl;

    private String description;
}
