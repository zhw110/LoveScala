/**
  * Created by zhanghongwei on 27.05.17.
  */
object Empty extends App{


  def gameResults(): Seq[(String, Int)] =
    ("Daniel", 3500) :: ("Melissa", 13000) :: ("John", 7000) :: Nil

  
  def hallOfFame = for {
    result <- gameResults()
    a<-Some(1)
    (name, score) = result
    if (score > 5000)
  } yield name

  println(hallOfFame)

}
