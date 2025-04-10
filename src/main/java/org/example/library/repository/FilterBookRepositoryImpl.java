package org.example.library.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.Predicate;
import lombok.RequiredArgsConstructor;
import org.example.library.dto.BookFilter;
import org.example.library.model.Book;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class FilterBookRepositoryImpl implements FilterBookRepository {
    private final EntityManager entityManager;

//    @Override
//    public List<Book> findAllByFilter(BookFilter filter) {
//        QPredicates builder = QPredicates.builder();
//        builder.add(filter.title(), book.title::containsIgnoreCase);
//        builder.add(filter.brand(), book.brand::containsIgnoreCase);
//        builder.add(filter.publicationYear(), book.publicationYear::containsIgnoreCase);
//        var predicate = builder
//                .build();
//
//        return new JPAQuery<Book>(entityManager)
//                .select(book)
//                .from(book)
//                .where(predicate)
//                .fetch();
//    }



    @Override
    public List<Book> findAllByFilter(BookFilter filter, int page, int size) {
        var criteriaBuilder = entityManager.getCriteriaBuilder();
        var criteriaQuery = criteriaBuilder.createQuery(Book.class);

        var root = criteriaQuery.from(Book.class);
        criteriaQuery.select(root);

        List<Predicate> predicates = new ArrayList<>();

        if (filter.title() != null && !filter.title().isBlank()) {
            predicates.add(criteriaBuilder.like(root.get("title"), filter.title()));
        }
        if (filter.brand() != null && !filter.brand().isBlank()) {
            predicates.add(criteriaBuilder.like(root.get("brand"), filter.brand()));
        }
        if (filter.publicationYear() != null && !filter.publicationYear().isBlank()) {
            predicates.add(criteriaBuilder.equal(root.get("publicationYear"), filter.publicationYear()));
        }
        criteriaQuery.where(predicates.toArray(Predicate[]::new));

        var query = entityManager.createQuery(criteriaQuery);
        query.setFirstResult(page * size);
        query.setMaxResults(size);

        return query.getResultList();
    }
}
