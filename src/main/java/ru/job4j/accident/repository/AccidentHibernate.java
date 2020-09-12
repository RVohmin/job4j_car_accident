package ru.job4j.accident.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ru.job4j.accident.model.Accident;

import java.util.List;
import java.util.function.Function;

//@Repository
public class AccidentHibernate {
    private final SessionFactory sf;

    public AccidentHibernate(SessionFactory sf) {
        this.sf = sf;
    }

    private <T> T tx(final Function<Session, T> command) {
        final Session session = sf.openSession();
        final Transaction tx = session.beginTransaction();
        try {
            T rsl = command.apply(session);
            tx.commit();
            return rsl;
        } catch (final Exception e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public void save(Accident accident) {
        tx(session -> session.save(accident));
    }

    public List<Accident> getAll() {
        return tx(session -> session.createQuery("from Accident", Accident.class).list());
    }

    public void update(Accident accident) {
        tx(session -> {
            session.saveOrUpdate(accident);
            return null;
        });
    }

    public Accident getAccidentById(int id) {
        return tx(session -> session.get(Accident.class, id));
    }
}
