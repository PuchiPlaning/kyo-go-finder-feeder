package application.service

import com.fooqoo56.kyogofinder.feeder.appication.service.TwitterService
import com.fooqoo56.kyogofinder.feeder.domain.repository.api.TwitterRepository
import com.fooqoo56.kyogofinder.feeder.infrastracture.api.dto.request.TwitterFollowerRequest
import com.fooqoo56.kyogofinder.feeder.infrastracture.api.dto.response.TwitterFollowerResponse
import spock.lang.Specification
import spock.lang.Unroll

class TwitterServiceSpec extends Specification {

    TwitterRepository twitterRepository
    TwitterService twitterService

    final setup() {
        twitterRepository = Mock(TwitterRepository)
    }


    @Unroll
    final "getFollower"() {
        given:
        twitterService = new TwitterService(twitterRepository)
        final response = new TwitterFollowerResponse()
        twitterRepository.getFollower(_ as TwitterFollowerRequest) >> response

        when:
        final result = twitterService.getFollower(id)

        then:
        result == expected

        where:
        id         || expected
        "12345678" || new TwitterFollowerResponse()
    }
}
