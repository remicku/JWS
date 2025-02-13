package fr.epita.assistants.shop.data.model;

import jakarta.persistence.*;

@Entity
@Table(name = "shop")
public class ShopModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    float price_multiplier;
    float upgrade_price;
}
