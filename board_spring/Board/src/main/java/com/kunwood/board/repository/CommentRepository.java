package com.kunwood.board.repository;

import com.kunwood.board.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * packageName : com.kunwood.board.repository
 * fileName : CommentRepository
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
@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, Integer> {
}
