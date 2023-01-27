package com.intesasoft.userInformation.Entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "LOGINTRACKING")
@Data
public class LoginTracking {
    @Id
    @Column(name = "userid")
    private Integer id;
    @Column(name = "Attemptdate")
    @DateTimeFormat(pattern = "yyyy-dd-MM HH:mm:ss")
    private LocalDateTime attemptDate;
    @Column(name = "attempttype")
    private String attemptType;

    public LoginTracking() {
    }

    public LoginTracking(Integer id, LocalDateTime attemptDate, String attemptType) {
        this.id = id;
        this.attemptDate = attemptDate;
        this.attemptType = attemptType;
    }
}
