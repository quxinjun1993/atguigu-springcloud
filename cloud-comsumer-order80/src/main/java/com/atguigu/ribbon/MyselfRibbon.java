package com.atguigu.ribbon;

import com.netflix.loadbalancer.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ps:这个类不能在 @ComponentScan 注解所扫描的包以及子包下
 *
 * 1.BestAvailableRule：
 * public class BestAvailableRule extends ClientConfigEnabledRoundRobinRule
 * 选择一个最小的并发请求的server
 * 逐个考察Server，如果Server被tripped了，则忽略，在选择其中ActiveRequestsCount最小的server
 *
 * 2.AvailabilityFilteringRule：
 * public class AvailabilityFilteringRule extends PredicateBasedRule
 * 过滤掉那些因为一直连接失败的被标记为circuit tripped的后端server，并过滤掉那些高并发的的后端server（active connections 超过配置的阈值）
 * 使用一个AvailabilityPredicate来包含过滤server的逻辑，其实就就是检查status里记录的各个server的运行状态
 *
 * 3.WeightedResponseTimeRule：
 * public class WeightedResponseTimeRule extends RoundRobinRule
 * 根据相应时间分配一个weight，相应时间越长，weight越小，被选中的可能性越低。
 * 一个后台线程定期的从status里面读取评价响应时间，为每个server计算一个weight。Weight的计算也比较简单responsetime 减去每个server自己平均的responsetime是server的权重。
 * 当刚开始运行，没有形成statas时，使用roubine策略选择server。
 *
 * 4.RetryRule：
 * public class RetryRule extends AbstractLoadBalancerRule
 * 对选定的负载均衡策略机上重试机制。
 * 在一个配置时间段内当选择server不成功，则一直尝试使用subRule的方式选择一个可用的server
 *
 * 5.RoundRobinRule：
 * public class RoundRobinRule extends AbstractLoadBalancerRule
 * roundRobin方式轮询选择server
 * 轮询index，选择index对应位置的server
 *
 * 6.RandomRule：
 * public class RandomRule extends AbstractLoadBalancerRule
 * 随机选择一个server
 * 在index上随机，选择index对应位置的server
 *
 * 7.ZoneAvoidanceRule：
 * public class ZoneAvoidanceRule extends PredicateBasedRule
 * 复合判断server所在区域的性能和server的可用性选择server
 * 使用ZoneAvoidancePredicate和AvailabilityPredicate来判断是否选择某个server，
 * 前一个判断判定一个zone的运行性能是否可用，剔除不可用的zone（的所有server），AvailabilityPredicate用于过滤掉连接数过多的Server。
 */
@Configuration
public class MyselfRibbon {

    @Bean
    public IRule getMyRule() {
        return new RandomRule();
//        return new RoundRobinRule();
//        return BestAvailableRule;
//        return new AvailabilityFilteringRule();
//        return new WeightedResponseTimeRule();
//        return new RetryRule();
//        return new ZoneAvoidanceRule();
    }

}
