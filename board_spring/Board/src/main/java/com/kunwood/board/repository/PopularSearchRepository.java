package com.kunwood.board.repository;

import com.kunwood.board.entity.PopularSearchEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * packageName : com.kunwood.board.repository
 * fileName : PopularSearchRepository
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
public interface PopularSearchRepository extends JpaRepository<PopularSearchEntity, String> {
}
