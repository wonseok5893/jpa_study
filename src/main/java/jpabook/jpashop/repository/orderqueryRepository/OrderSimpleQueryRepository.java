package jpabook.jpashop.repository.orderqueryRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class OrderSimpleQueryRepository {

    private final EntityManager em;

    public List<OrderSimpleQueryDto> findOrderDtos() {
        return em.createQuery("select new jpabook.jpashop.repository.orderqueryRepository.OrderSimpleQueryDto(o.id, m.name, o.orderDate ,o.status, d.address)  from Order o"+
                " join o.member m"+
                " join o.delivery d", OrderSimpleQueryDto.class).getResultList();
    }
}
