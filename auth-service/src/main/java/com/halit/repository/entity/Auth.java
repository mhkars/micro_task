package com.halit.repository.entity;

import com.halit.repository.enums.Roles;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity(name = "auth")
public class Auth {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true,nullable = false)
    private String username;
    private String name;
    private String surname;
    private Long companyId;
    private String companyName;
    private String password;
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private Roles role=Roles.Standart;
    private String activatedCode;

}
