package org.appfuse.tutorial.dao;

import org.appfuse.dao.BaseDaoTestCase;
import org.appfuse.tutorial.model.GameField;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import java.util.List;

import static org.junit.Assert.*;

public class GameFieldDaoTest extends BaseDaoTestCase {
    @Autowired
    private GameFieldDao gameFieldDao;

    @Test
    public void testFindGameFieldByPhone() throws Exception {
        List<GameField> gameField = gameFieldDao.findByPhone("80012345678");
        assertTrue(gameField.size() > 0);
    }

    @Test(expected=DataAccessException.class)
    public void testAddAndRemoveGameField() throws Exception {
        GameField gameField = new GameField();
        gameField.setName("Country");
        gameField.setPhone("800456");

        gameField = gameFieldDao.save(gameField);
        flush();

        gameField = gameFieldDao.get(gameField.getId());

        assertEquals("Country", gameField.getName());
        assertNotNull(gameField.getId());

        log.debug("removing gameField...");

        gameFieldDao.remove(gameField.getId());
        flush();

        // should throw DataAccessException
        gameFieldDao.get(gameField.getId());
    }
}