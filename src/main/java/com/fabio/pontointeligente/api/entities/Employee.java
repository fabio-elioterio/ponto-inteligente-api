package com.fabio.pontointeligente.api.entities;

import com.fabio.pontointeligente.api.enums.ProfileEnum;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "employee")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String cpf;

    @Column(name = "hour_valor")
    @Transient
    private BigDecimal hourValor;

    @Column(name = "qtd_work_day_hour")
    @Transient
    private Float qtdWorkDayHours;

    @Column(name = "qtd_lunch_hours")
    @Transient
    private Float qtdLunchHours;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ProfileEnum profile;

    @Column(name = "creation_date")
    private Date creationDate;

    @Column(name = "update_date")
    private Date updateDate;

    @ManyToOne(fetch = FetchType.EAGER)
    private Company company;

    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Entry> entries;

    @PreUpdate
    public void preUpdate() {
        updateDate = new Date();
    }

    @PrePersist
    public void prePersist() {
        final Date actual = new Date();
        creationDate = actual;
        updateDate = actual;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", cpf='" + cpf + '\'' +
                ", hourValor=" + hourValor +
                ", qtdWorkDayHours=" + qtdWorkDayHours +
                ", qtdLunchHours=" + qtdLunchHours +
                ", profile=" + profile +
                ", creationDate=" + creationDate +
                ", updateDate=" + updateDate +
                ", company=" + company +
                ", entries=" + entries +
                '}';
    }
}
