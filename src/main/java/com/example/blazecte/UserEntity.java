package com.example.blazecte;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@Table(name = "usr")
@ToString(exclude = "posts")
public class UserEntity {
  @Id
  private String id;
  private String email;

  @OneToMany(mappedBy = "user")
  private Set<PostEntity> posts;
}
