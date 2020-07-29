package com.fabio.pontointeligente.api.entities;

import com.fabio.pontointeligente.api.enums.TypeEnum;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "entry")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Entry implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @Column
    private String description;

    @Column
    private String localization;

    @Column(name = "creation_date")
    private Date creationDate;

    @Column(name = "update_date")
    private Date updateDate;

    @Column(name = "type_enum", nullable = false)
    private TypeEnum typeEnum;

    @ManyToOne(fetch = FetchType.EAGER)
    private Employee employee;

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
        return "Entry{" +
                "id=" + id +
                ", date=" + date +
                ", description='" + description + '\'' +
                ", localization='" + localization + '\'' +
                ", creationDate=" + creationDate +
                ", updateDate=" + updateDate +
                ", typeEnum=" + typeEnum +
                ", employee=" + employee +
                '}';
    }
}
