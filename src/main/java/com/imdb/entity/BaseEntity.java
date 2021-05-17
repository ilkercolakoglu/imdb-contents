package com.imdb.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @developer -- ilkercolakoglu
 */

@MappedSuperclass
@Data
public abstract class BaseEntity implements Serializable {



}
