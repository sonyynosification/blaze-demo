package com.example.blazecte;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "post")
@Getter
@Setter
public class PostEntity {
  @Id
  private String id;
  private String title;

  @ManyToOne(fetch = FetchType.LAZY)
  private UserEntity user;
}
