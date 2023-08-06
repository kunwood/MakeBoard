package com.kunwood.board.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * packageName : com.kunwood.board.entity
 * fileName : CommentEntity
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
@Entity(name = "comment" )
@Table(name = "comment")
public class CommentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int commentId;
    private int boardNumber;
    private String userEmail;
    private String commentUserProfile;
    private String commentUserNickname;
    private String commentWriteDate;
    private String commentContent;

}
