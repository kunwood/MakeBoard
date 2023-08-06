package com.kunwood.board.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * packageName : com.kunwood.board.entity
 * fileName : LikyEntity
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
@Entity(name = "Liky" )
@Table(name = "Liky" )
public class LikyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int likeId;
    private int boardNumber;
    private String userEmail;
    private String likeUserProfile;
    private String likeUserNickname;

}
