package com.relation.backend.Advt.entity;

import lombok.*;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;

import com.relation.backend.Advt.entity.Employee;;

@Data
@Entity
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Table(name="ADVERTISEMENT")
public class Advertisement  {
  @Id
  @SequenceGenerator(name="ADVERTISEMENT_SEQ",sequenceName="ADVERTISEMENT_SEQ")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="ADVERTISEMENT_SEQ" )
  @Column(name = "ID_ADVERTISEMENT", unique = true, nullable = true)
  private @NonNull Long id;

  @Column(name="AD_TITLE")
  private @NonNull String adTitle;

  @Column(name="AD_LINK")
  private @NonNull String adLink;

  @Column(name="AD_DATE")
  private @NonNull Date adDate;

  @ManyToOne(fetch = FetchType.EAGER, targetEntity = Employee.class)
  @JoinColumn(name = "ID_EMPOLYEE", insertable = true)
  private Employee employee;

  @ManyToOne(fetch = FetchType.EAGER, targetEntity = Adtype.class)
  @JoinColumn(name = "ID_ADTYPE", insertable = true)
  private Adtype type;

  @ManyToOne(fetch = FetchType.EAGER, targetEntity = Sponsor.class)
  @JoinColumn(name = "ID_SPONSOR", insertable = true)
  private Sponsor sponsor;
}