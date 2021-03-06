package rs.levi9.socbook1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.levi9.socbook1.domain.Bookmark;
import rs.levi9.socbook1.domain.Category;
import rs.levi9.socbook1.domain.Comment;
import rs.levi9.socbook1.domain.User;

import java.util.List;

@Repository
public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {

    List<Bookmark> findAllByUser(User user);

    List<Bookmark> findAllByIsPublicTrueAndUserNot(User user);

    Bookmark findByUrl(String url);

    Bookmark findByUserAndUrl(User user, String url);

    List<Bookmark> findAllBookmarksByCategoryId(Long id);

    Bookmark findBookmarkByCommentsId(Long id);

    Bookmark findBookmarkByRatingsId(Long id);
}
