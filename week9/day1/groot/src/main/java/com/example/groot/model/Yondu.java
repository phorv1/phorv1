package com.example.groot.model;

import com.example.groot.service.GuardianRepository;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@NoArgsConstructor
@Component
public class Yondu implements GuardianRepository {

  double distance;
  double time;
  double speed;

  public void setSpeed() {
    this.speed = distance / time;
  }
}
