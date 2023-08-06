package com.kunwood.board.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * packageName : com.kunwood.board.entity
 * fileName : PopularSearchEntity
 * author : geonu
 * date : 2023/08/06
 * description :
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2023/08/06         geonu          최초 생성
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "PopularSearch")
@Table(name = "PopularSearch")
public class PopularSearchEntity {
    @Id
    private String popularTerm;
    private int popularSearchCount;
}
