package top.w2gd.content.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.w2gd.content.domain.entity.Share;
import top.w2gd.content.repository.ShareRepository;
import top.w2gd.content.service.ShareService;

/**
 * @author w2gd
 */
@Slf4j
@Service
@RequiredArgsConstructor(onConstructor =  @__(@Autowired))
public class ShareServiceImpl implements ShareService {

    private final ShareRepository shareRepository;
    @Override
    public Share findById(Integer id) {
        return shareRepository.findById(id).orElse(null);
    }
}
