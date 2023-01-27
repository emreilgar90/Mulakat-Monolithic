package com.emreilgar.repository.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "LOGINTRACKING")
public class LoginTracking {
    @Id
    private int userid;
    private Date date;

    private AtemptType atemptType;

}
