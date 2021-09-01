package com.everis.servicebootcoin.models.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("bootcoin")
public class BootCoin implements Serializable {
    @Id
    private String id;
    private Double buy;
    private Double sell;
}
