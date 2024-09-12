package org.example.freelance_project_overone.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "client")
@Data
public class ClientModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column(name = "client_name")
    String clientName;

    @Column(name = "wanted_item")
    String wantedItem;

    @Column(name = "contact")
    String contact;

    @Column(name = "actual")
    boolean actual;
}
