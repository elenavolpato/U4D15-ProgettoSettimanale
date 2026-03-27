package elena.dao;

import elena.entities.Client;
import jakarta.persistence.*;

public class ClientDAO {
    private EntityManager em;
    public ClientDAO (EntityManager em){this.em = em;}

    public void save(Client client){
        try {
            EntityTransaction t = em.getTransaction();
            t.begin();
            em.persist(client);
            t.commit();
            System.out.println("Client " + client.getLastName() + " was created in the database");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Client findByMembershipNum(long num) {
        try {
            return em.createQuery(
                            "SELECT c FROM Client c WHERE c.membershipNum = :num",
                            Client.class)
                    .setParameter("num", num)
                    .getSingleResult();
        } catch (NoResultException e) {
            System.out.println("No client found with membership number: " + num);
            return null;
        } catch (Exception e) {
            System.err.println("Error searching for client: " + e.getMessage());
            return null;
        }
    }

}
