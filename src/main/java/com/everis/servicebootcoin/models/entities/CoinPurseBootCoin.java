package com.everis.servicebootcoin.models.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("coinPurseBootCoin")
public class CoinPurseBootCoin implements Serializable {

    @Id
    private String id;
    @NotNull
    private String typeDocument;
    @NotNull
    private String numberDocument;
    @NotNull
    private String phoneNumber;
    @NotNull
    private String email;
}
