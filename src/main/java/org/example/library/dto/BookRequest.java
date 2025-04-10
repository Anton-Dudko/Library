package org.example.library.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookRequest {
    private String vendorCode;
    private String title;
    private int publicationYear;
    private String brand;
    private int stock;
    private double price;
}
