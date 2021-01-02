package com.fooqoo56.kyogofinder.feeder.infrastracture.api.dto.request;

import com.fooqoo56.kyogofinder.feeder.infrastracture.api.dto.response.TwitterFollowerResponse;
import java.io.Serializable;
import lombok.Builder;
import lombok.Value;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@Value
@Builder
public class KyoGoFinderUserApiRequest implements Serializable {

    private static final long serialVersionUID = -3672939325231369161L;

    private static final String NAME_BODY = "name";
    private static final String SCREEN_NAME_BODY = "screenName";
    private static final String DESCRIPTION_BODY = "description";
    private static final String FOLLOWERS_COUNT_BODY = "followersCount";
    private static final String FRIENDS_COUNT_BODY = "friendsCount";
    private static final String STATUSES_COUNT_BODY = "statusesCount";
    private static final String PROFILE_IMAGE_URL_HTTPS_BODY = "profileImageUrlHttps";

    // パスパラメータ :id
    String id;

    // パスパラメータ :followerId
    String followerId;

    String name;
    String screenName;
    String description;
    Integer followersCount;
    Integer friendsCount;
    Integer statusesCount;
    String profileImageUrlHttps;

    /**
     * twitterレスポンスをKyoGoAPIのリクエストに変換.
     *
     * @param user ユーザ
     * @return KyoGoAPIのリクエスト
     */
    public static KyoGoFinderUserApiRequest convertTwitterResToKyoGoReq(
            final TwitterFollowerResponse.User user, final String id) {
        return KyoGoFinderUserApiRequest
                .builder()
                .id(id)
                .followerId(user.getId())
                .name(user.getName())
                .screenName(user.getUsername())
                .description(user.getDescription())
                .followersCount(user.getPublicMetrics().getFollowersCount())
                .friendsCount(user.getPublicMetrics().getFollowingCount())
                .statusesCount(user.getPublicMetrics().getTweetCount())
                .profileImageUrlHttps(user.getProfileImageUrl())
                .build();
    }

    /**
     * body取得.
     *
     * @return MultiValueMap<String, String>
     */
    public MultiValueMap<String, String> getBody() {
        final MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add(NAME_BODY, name);
        body.add(SCREEN_NAME_BODY, screenName);
        body.add(DESCRIPTION_BODY, description);
        body.add(FOLLOWERS_COUNT_BODY, followersCount.toString());
        body.add(FRIENDS_COUNT_BODY, friendsCount.toString());
        body.add(STATUSES_COUNT_BODY, statusesCount.toString());
        body.add(PROFILE_IMAGE_URL_HTTPS_BODY, profileImageUrlHttps);

        return body;
    }
}
