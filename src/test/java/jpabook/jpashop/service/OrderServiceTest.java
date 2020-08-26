package jpabook.jpashop.service;

import jpabook.jpashop.domain.Address;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.domain.Order;
import jpabook.jpashop.domain.OrderStatus;
import jpabook.jpashop.domain.exception.NotEnoughStockException;
import jpabook.jpashop.domain.item.Book;
import jpabook.jpashop.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
@SpringBootTest
class OrderServiceTest {

    @Autowired
    EntityManager em;
    @Autowired OrderService orderService;
    @Autowired
    OrderRepository orderRepository;
   @Test
   public void order() throws Exception {
       //given
       Member member = createMember();
       Book book = createBook("시골 JPA", 10000, 10);

       int orderCount =2;
       //when
       Long order = orderService.order(member.getId(), book.getId(), orderCount);
       //then
       Order one = orderRepository.findOne(order);

      assertEquals(OrderStatus.ORDER,one.getStatus());
      assertEquals(1,one.getOrderItems().size());
      assertEquals(10000*orderCount,one.getTotalPrice());
      assertEquals(8,book.getStockQuantity());

   }

    private Book createBook(String name, int price, int stockQuantity) {
        Book book = new Book();
        book.setName(name);
        book.setPrice(price);
        book.setStockQuantity(stockQuantity);
        em.persist(book);
        return book;
    }

    private Member createMember() {
        Member member = new Member();
        member.setName("회원1");
        member.setAddress(new Address("서울","감가","123-123"));
        em.persist(member);
        return member;
    }

    /* @Test
   public void 재고수량초과() throws Exception {
       //given
        Member member = createMember();
        Book book = createBook("시골 JPA", 10000, 10);

        int orderCount =11;
        //when

        orderService.order(member.getId(), book.getId(), orderCount);


       //then
        fail("재고수량 부족 예외가 발생 해야한다");
   } */



    @Test
    public void 주문취소() throws Exception {
        //given
        Member member = createMember();
        Book book = createBook("jpa",10000,10);

        int orderCount =2;

        Long orderId = orderService.order(member.getId(),book.getId(),orderCount);

        //when

        orderService.cancelOrder(orderId);


        //then
        Order getOrder = orderRepository.findOne(orderId);

        assertEquals(OrderStatus.CANCEL,getOrder.getStatus());
        assertEquals(10,book.getStockQuantity());

    }

    @Test
    public void 상품주문_재고수량초과() throws Exception {
        //given

        //when


        //then
    }


}