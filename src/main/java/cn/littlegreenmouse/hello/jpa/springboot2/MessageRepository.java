package cn.littlegreenmouse.hello.jpa.springboot2;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
